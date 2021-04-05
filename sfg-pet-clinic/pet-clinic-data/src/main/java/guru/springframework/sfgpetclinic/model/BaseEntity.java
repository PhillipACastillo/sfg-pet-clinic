package guru.springframework.sfgpetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

// Mapped Super Class informs Spring Context that this class
  // is only used for inheritance and therefore it does not
  // require special attention
@MappedSuperclass
public class BaseEntity implements Serializable {

    // Use box types in case we have null values
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
