package miniProject2;

import miniProject.DuplicateContactInGroup;

public class Group implements Comparable<Group> {
	
	private static  int contactArraySize=25;
	 private String groupName;
	    private String groupDescription;
	    private Contact[] contacts=new Contact[contactArraySize];
	    private int contactCount;

	    public Group(String groupName, String groupDescription) {
	        this.groupName = groupName;
	        this.groupDescription = groupDescription;
	        this.contactCount = 0;
	    }

	    // Getters and setters
	    public String getGroupName() { return groupName; }
	    public void setGroupName(String groupName) { this.groupName = groupName; }

	    public String getGroupDescription() { return groupDescription; }
	    public void setGroupDescription(String groupDescription) { this.groupDescription = groupDescription; }

	    public Contact[] getContacts() { return contacts; }

	    public void addContact(Contact contact) throws  DuplicateContactInGroup {
	    	 
	         for (int i = 0; i < contactCount; i++) {
	             if (contacts[i] == contact) {
	                 throw new DuplicateContactInGroup("Contact is already in the group.");
	             }
	         }
	         contacts[contactCount++] = contact;
	    }
	             
	        
	   
	    
	    

	    public void removeContact(Contact contact) throws ContactNotFound{
	    	boolean found=false;
	        for (int i = 0; i < contactCount; i++) {
	            if (contacts[i].equals(contact)) {
	                contacts[i] = contacts[contactCount - 1]; // Replace with the last contact
	                contacts[contactCount - 1] = null;
	                contactCount--;
	                found=true;
	                break;
	                
	            }
	        }
	        if(!found){
	        	
	        	throw new  ContactNotFound("contact not in group");
	        }
	    }

		@Override
		public int compareTo(Group o) {
			
			return this.groupName.compareTo(o.groupName);
		}

}