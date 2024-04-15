package gpms.zecaronas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="\"user\"")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  public String name;
  public String email;
}
