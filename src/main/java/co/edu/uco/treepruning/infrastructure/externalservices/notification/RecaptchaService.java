package co.edu.uco.treepruning.infrastructure.externalservices.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Value;

@Service
@Slf4j

public class RecaptchaService {
	
	private static final Logger log = LoggerFactory.getLogger(RecaptchaService.class);

    private static final String VERIFY_URL =
        "https://www.google.com/recaptcha/api/siteverify";
    private static final double MIN_SCORE = 0.5;

    @Value("${recaptcha.secret-key}")
    private String secretKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean validate(String token) {
        if (token == null || token.isBlank()) {
            log.warn("RecaptchaService — token vacío");
            return false;
        }
        try {
            String url = VERIFY_URL + "?secret=" + secretKey + "&response=" + token;
            RecaptchaResponse response = restTemplate.getForObject(url, RecaptchaResponse.class);
            boolean valid = response != null && response.isSuccess() && response.getScore() >= MIN_SCORE;
            log.info("RecaptchaService — score: {}, valid: {}", 
                response != null ? response.getScore() : "null", valid);
            return valid;
        } catch (Exception e) {
            log.error("RecaptchaService — error validando token: {}", e.getMessage());
            return false;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RecaptchaResponse {
        private boolean success;
        private double  score;
        private String  action;

        public boolean isSuccess() { return success; }
        public double  getScore()  { return score;   }
        public String  getAction() { return action;  }

        public void setSuccess(boolean success) { this.success = success; }
        public void setScore(double score)      { this.score   = score;   }
        public void setAction(String action)    { this.action  = action;  }
    }
}