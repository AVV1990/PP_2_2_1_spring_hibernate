package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;


   @OneToOne(mappedBy = "user")
   private Car car;

   public User() {
   }

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;

   }

   public Long getId() {
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

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public boolean equals(Object object) {
      if (object == this) {
         return true;
      }

      if (object == null || object.getClass() != this.getClass()) {
         return false;
      }

      User user = (User) object;
      return (this.firstName == user.firstName || (this.firstName != null && this.firstName.equals(user.getFirstName())))
              && (this.lastName == user.lastName || (this.lastName != null && this.lastName.equals(user.getLastName())))
              && (this.email == user.email || (this.email != null && this.email.equals(user.getEmail())));
   }


   @Override
   public int hashCode() {
      return 31 + (firstName == null ? 0 : firstName.hashCode()) + (lastName == null ? 0 : lastName.hashCode()) + (email == null ? 0 : email.hashCode());
   }

   @Override
   public String toString() {
      return String.format("User [name = %s, lastName = %s, email = %s]", firstName, lastName, email);
   }

}
