package co.edu.uco.treepruning.application.inputport.impl;


import co.edu.uco.treepruning.application.inputport.SubmitPQRInputPort;
import co.edu.uco.treepruning.application.inputport.dto.SubmitPQRDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor=Exception.class)
public class SubmitPQRInteractor implements SubmitPQRInputPort {


    @Override
    public Void execute(SubmitPQRDTO data) {
        return null;
    }
}
