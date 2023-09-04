package genericutility;

public interface EndPointsLibrary {

	String createProject = "/addProject";
	String getAllProjects = "/projects";
	String getProject = "/projects/{projectId}";
	String updateProject = "/projects/{projectId}";
	String deleteProject = "/projects/{projectId}";
}
