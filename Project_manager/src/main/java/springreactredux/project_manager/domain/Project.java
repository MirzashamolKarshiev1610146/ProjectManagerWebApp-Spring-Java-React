package springreactredux.project_manager.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@EntityScan("springreactredux.project_manager.domain")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Valid
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At;
    @Valid
    @NotNull(message = "Project descriptiom is required")
    private String description;
    @Valid
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date;
    @Valid
    @NotNull (message = "Project identifier is required")
    @Size(min = 4, max = 5, message = "Please use 4 to 5 characters")
    @Column(updatable = true,unique = true)
    private String projectIdentifier;
    @Valid
    @NotNull (message = "Project name is required")
    private String projectName;
    @Valid
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date start_date;
    @Valid
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date updated_At;

    public Project() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    @PrePersist
    protected void OnCreate()
    {
        this.created_At = new Date();
    }
    @PreUpdate
    protected void onUpdate()
    {
        this.updated_At = new Date();
    }

}
