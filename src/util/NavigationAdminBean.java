package util;

import java.io.Serializable; 
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class NavigationAdminBean implements Serializable {

	// selected include contents.
	private String selectedIncludePath = "/WEB-INF/includes/main/student/home.xhtml";

	/**
	 * Gets the currently selected content include path.
	 *
	 * @return currently selected content include path.
	 */
	public String getSelectedIncludePath() {
		// check for a currently selected path to be ready for ui:include
		FacesContext context = FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		String requestedPath = (String) map.get("includePath");
		if ((null != requestedPath) && (requestedPath.length() > 0)) {
			selectedIncludePath = requestedPath;
		}
		return selectedIncludePath;
	}

	/**
	 * Sets the selected content include path to the specified path.
	 *
	 * @param selectedIncludePath
	 *            the specified content include path.
	 */
	public void setSelectedIncludePath(String selectedIncludePath) {
		this.selectedIncludePath = selectedIncludePath;
	}

	/**
	 * Action Listener for the changes the selected content path in the facelets
	 * version of component showcase.
	 *
	 * @param event
	 *            JSF Action Event.
	 */
	public void navigationPathChange(ActionEvent event) {

		// get from the context content include path to show as well
		// as the title associated with the link.
		FacesContext context = FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		selectedIncludePath = (String) map.get("includePath");
	}
}
