package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

// Mapped Super Class informs Spring Context that this class
  // is only used for inheritance and therefore it does not
  // require special attention
@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    // Use box types in case we have null values
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
