package br.edu.utfpr.cm.minerador.model.issue;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Rodrigo T. Kuroda
 */
@Entity
@Table(name = "issues_ext_jira",
        indexes = {
            @Index(columnList = "issue_key")
        }
)
public class IssueExtJira implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "issue_key", length = 32)
    private String issueKey;
    @Basic(optional = false)
    @Column(name = "link", length = 100)
    private String link;
    @Basic(optional = false)
    @Column(name = "title", length = 100)
    private String title;
    @Basic(optional = false)
    @Column(name = "environment", length = 35)
    private String environment;
    @Basic(optional = false)
    @Column(name = "security", length = 35)
    private String security;
    @Basic(optional = false)
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @Basic(optional = false)
    @Column(name = "version", length = 35)
    private String version;
    @Basic(optional = false)
    @Column(name = "component", length = 35)
    private String component;
    @Column(name = "votes")
    private Integer votes;
    @Basic(optional = false)
    @Column(name = "project", length = 35)
    private String project;
    @Column(name = "project_id")
    private Integer projectId;
    @Basic(optional = false)
    @Column(name = "project_key", length = 35)
    private String projectKey;
    @Basic(optional = false)
    @Column(name = "status", length = 35)
    private String status;
    @Basic(optional = false)
    @Column(name = "resolution", length = 35)
    private String resolution;
    @Basic(optional = false)
    @Column(name = "issue_id")
    private int issueId;

    public IssueExtJira() {
    }

    public IssueExtJira(Integer id) {
        this.id = id;
    }

    public IssueExtJira(Integer id, String issueKey, String link, String title, String environment, String security, Date updated, String version, String component, String project, String projectKey, String status, String resolution, int issueId) {
        this.id = id;
        this.issueKey = issueKey;
        this.link = link;
        this.title = title;
        this.environment = environment;
        this.security = security;
        this.updated = updated;
        this.version = version;
        this.component = component;
        this.project = project;
        this.projectKey = projectKey;
        this.status = status;
        this.resolution = resolution;
        this.issueId = issueId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IssueExtJira)) {
            return false;
        }
        IssueExtJira other = (IssueExtJira) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.cm.minerador.model.issue.IssueExtJira[ id=" + id + " ]";
    }

}
