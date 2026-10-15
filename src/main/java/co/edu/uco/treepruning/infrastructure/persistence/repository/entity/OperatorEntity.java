package co.edu.uco.treepruning.infrastructure.persistence.repository.entity;

import java.util.UUID;

import co.edu.uco.treepruning.crosscutting.helper.ObjectHelper;
import co.edu.uco.treepruning.crosscutting.helper.UUIDHelper;

public class OperatorEntity {
	private UUID id;
	private PersonEntity person;
	private QuadrilleEntity quadrille;
<<<<<<< Updated upstream

=======
	
>>>>>>> Stashed changes
	public OperatorEntity() {
		super();
		setId(UUIDHelper.getDefault());
		setPerson(new PersonEntity());
		setQuadrille(new QuadrilleEntity());
	}

	public OperatorEntity(final UUID id) {
		super();
		setId(id);
		setPerson(new PersonEntity());
		setQuadrille(new QuadrilleEntity());
	}
<<<<<<< Updated upstream

=======
	
>>>>>>> Stashed changes
	public OperatorEntity(final UUID id, final PersonEntity person, final QuadrilleEntity quadrille) {
		super();
		setId(id);
		setPerson(person);
		setQuadrille(quadrille);
	}

	public UUID getId() {
		return id;
	}

	public PersonEntity getPerson() {
		return person;
	}
<<<<<<< Updated upstream

	public QuadrilleEntity getQuadrille() {
		return quadrille;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id);
	}

	public void setPerson(final PersonEntity person) {
		this.person = ObjectHelper.getDefault(person, new PersonEntity());
	}

	public void setQuadrille(final QuadrilleEntity quadrille) {
		this.quadrille = ObjectHelper.getDefault(quadrille, new QuadrilleEntity());
	}

=======
	
	public QuadrilleEntity getQuadrille() {
		return quadrille;
	}
	
	public void setId(final UUID id) {
		this.id = UUIDHelper.getDefault(id);
	}
	
	public void setPerson(final PersonEntity person) {
		this.person = ObjectHelper.getDefault(person, new PersonEntity());
	}
	
	public void setQuadrille(final QuadrilleEntity quadrille) {
		this.quadrille = ObjectHelper.getDefault(quadrille, new QuadrilleEntity());
	}
	
>>>>>>> Stashed changes
}
