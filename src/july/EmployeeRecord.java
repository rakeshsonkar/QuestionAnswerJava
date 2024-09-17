package july;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings("serial")
public class EmployeeRecord implements Serializable {

	private final String first;
	private final String last;
	private final Set<String> projects;
	public EmployeeRecord(String first, String last, Set<String> projects) {
		super();
		this.first = first;
		this.last = last;
		this.projects = projects;
	}
	public String getFirst() {
		return first;
	}
	public String getLast() {
		return last;
	}
	public Set<String> getProjects() {
		return projects;
	}
	@Override
	public int hashCode() {
		return Objects.hash(first, last, projects);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRecord other = (EmployeeRecord) obj;
		return Objects.equals(first, other.first) && Objects.equals(last, other.last)
				&& Objects.equals(projects, other.projects);
	}
	@Override
	public String toString() {
		return "EmployeeRecord [first=" + first + ", last=" + last + ", projects=" + projects + "]";
	}
	
	
	
}
