package entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


    @Entity
    @Table(name = "PROJECT")
    public class Project implements Serializable{

        private static final long serialVersionUID = 10514307451906927L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "TITLE")
        private String title;

        @ManyToMany(mappedBy = "projects")
        private Set<Employee> employees;


        public Project() {

    }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Set<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(Set<Employee> employees) {
            this.employees = employees;
        }


    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
