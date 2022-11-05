package web.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private long id;

   @Column
   private String firstName;

   @Column
   private String lastName;

   @Column
   private String email;
   public Users(){}

   public Users(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Users(long id, String firstName, String lastName, String email) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

}
