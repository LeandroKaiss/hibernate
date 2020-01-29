import javax.persistence.*;

@Entity
@Table(name = "table1")
public class Schema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sample1")
    private String sample1;

    @Column(name = "sample2")
    private int sample2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSample1() {
        return sample1;
    }

    public void setSample1(String sample1) {
        this.sample1 = sample1;
    }

    public int getSample2() {
        return sample2;
    }

    public void setSample2(int sample2) {
        this.sample2 = sample2;
    }
}
