/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pakacoco
 */
@Entity
@Table(name = "CLASSES", catalog = "eAdministration", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Classes.findAll", query = "SELECT c FROM Classes c"),
    @NamedQuery(name = "Classes.findByClassID", query = "SELECT c FROM Classes c WHERE c.classID = :classID"),
    @NamedQuery(name = "Classes.findByClassName", query = "SELECT c FROM Classes c WHERE c.className = :className"),
    @NamedQuery(name = "Classes.findByAmountTime", query = "SELECT c FROM Classes c WHERE c.amountTime = :amountTime")})
public class Classes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "classID", nullable = false, length = 15)
    private String classID;
    @Basic(optional = false)
    @Column(name = "className", nullable = false, length = 100)
    private String className;
    @Basic(optional = false)
    @Column(name = "amountTime", nullable = false)
    private double amountTime;
    @JoinColumn(name = "departmentID", referencedColumnName = "departmentID", nullable = false)
    @ManyToOne(optional = false)
    private Department department;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classes")
    private List<Timetable> timetableList;

    public Classes() {
    }

    public Classes(String classID) {
        this.classID = classID;
    }

    public Classes(String classID, String className, double amountTime) {
        this.classID = classID;
        this.className = className;
        this.amountTime = amountTime;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getAmountTime() {
        return amountTime;
    }

    public void setAmountTime(double amountTime) {
        this.amountTime = amountTime;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Timetable> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<Timetable> timetableList) {
        this.timetableList = timetableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (classID != null ? classID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classes)) {
            return false;
        }
        Classes other = (Classes) object;
        if ((this.classID == null && other.classID != null) || (this.classID != null && !this.classID.equals(other.classID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Classes[classID=" + classID + "]";
    }

}