package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Car() {
    }

    public Car(String model, int series, User user) {
        this.model = model;
        this.series = series;
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Car car = (Car) object;
        return this.series == car.series
                && (this.model == car.model || (this.model != null && this.model.equals(car.getModel())))
                && (this.user.equals(car.user));
    }


    @Override
    public int hashCode() {
        return 31 + (series == 0 ? 0 : Integer.valueOf(series).hashCode()) + (model == null ? 0 : model.hashCode()) + (user == null ? 0 : user.hashCode());
    }

    @Override
    public String toString() {
        return String.format("Car = [model = %s, series = %d]", model, series);
    }
}
