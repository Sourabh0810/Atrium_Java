package miniProject2;

import miniProject.DuplicateGroupNameException;
import miniProject.DuplicateNameException;

public class GroupServices {
	
	private Group[] groups;
      int groupCount;

    public GroupServices(int initialSize) {
        this.groups = new Group[initialSize];
        this.groupCount = 0;
    }

    public void createGroup(String groupName, String groupDescription)throws DuplicateGroupNameException {
        if (groupCount < groups.length) {
        	
        	
        	for (int i = 0; i < groupCount; i++) {
                if (groups[i].getGroupName().equals(groupName)) {
                  
                 //   throw new DuplicateContactException("This contact already exists.");
                	// throw new DuplicateNameException("This Name is already exist");
                	throw new DuplicateGroupNameException("The Group  is already exist ! ");
                }
            }
        	
        	
            groups[groupCount++] = new Group(groupName, groupDescription);
        } else {
           
            System.out.println("No more groups can be created");
        }
    }

    public Group getGroup(String groupName) {
        for (int i = 0; i < groupCount; i++) {
            if (groups[i].getGroupName().equals(groupName)) {
                return groups[i];
            }
        }
        return null;
    }

    public void updateGroup(String groupName, String newDescription) {
        Group group = getGroup(groupName);
        if (group != null) {
            group.setGroupDescription(newDescription);
        }
    }

    public void deleteGroup(String groupName) {
        for (int i = 0; i < groupCount; i++) {
            if (groups[i].getGroupName().equals(groupName)) {
                groups[i] = groups[groupCount - 1]; // Replace with the last group
                groups[groupCount - 1] = null;
                groupCount--;
                break;
            }
        }
    }

    public Group[] getAllGroups() {
        return groups;
    }
    public Group[] getAllGroupSorted() {
    	Group[] sortedGroup = new Group[groupCount];
        // Copying
        for (int i = 0; i < groupCount; i++) {
        	sortedGroup[i] = groups[i];
        }

        // Bubble sort the copied array
        boolean swapped;
        for (int i = 0; i < groupCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < groupCount - i - 1; j++) {
                if (sortedGroup[j].compareTo(sortedGroup[j + 1]) > 0) {
                    // Swap sortedContacts[j] and sortedContacts[j + 1]
                    Group temp = sortedGroup[j];
                    sortedGroup[j] = sortedGroup[j + 1];
                    sortedGroup[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // No swapping means the array is already sorted
        }
        return sortedGroup;
        
    }
	
}