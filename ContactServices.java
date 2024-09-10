package miniProject2;

import miniProject.ContactLimitExceededException;

import miniProject.DuplicateContactException;
import miniProject.DuplicateContactInGroup;
import miniProject.DuplicateNameException;
import miniProject.PhoneNumberLimitException;


public class ContactServices {
	
	
	private Contact[] contacts;
    private int contactCount;

    public ContactServices(int initialSize)
    {
        this.contacts = new Contact[initialSize];
        this.contactCount = 0;
    }
    
    public void createContact(String name, String phoneNumber, String countryCode)throws ContactLimitExceededException,PhoneNumberLimitException,DuplicateContactException,DuplicateNameException {
        
//    	if (contactCount < contacts.length) {
//  
//    		throw new ContactLimitExceededException("no other contact is created your limit is 2 only");
//    	}
                
             
    	if(phoneNumber.length()!= 10) {
    		throw new PhoneNumberLimitException("Only 10 digit contact numbers are accepted");
    	}
        	
        	for (int i = 0; i < contactCount; i++) {
                if (contacts[i].getPhoneNumber().equals(phoneNumber)) {
                  
                    throw new DuplicateContactException("This contact already exists.");
                }
            }
        	for (int i = 0; i < contactCount; i++) {
                if (contacts[i].getName().equals(name)) {
                  
                 //   throw new DuplicateContactException("This contact already exists.");
                	throw new DuplicateNameException("This Name is already exist");
                }
            }
        	
        	
        	contacts[contactCount++]=new Contact(name,phoneNumber,countryCode);
        } 
       
       
 

    public Contact getContact(String phoneNumber) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getPhoneNumber().equals(phoneNumber)) {
                return contacts[i];
            }
        }
        return null;
    }

    public void updateContact(String phoneNumber, String newName, String newCountryCode) {
        Contact contact = getContact(phoneNumber);
        if (contact != null) {
            contact.setName(newName);
            contact.setCountryCode(newCountryCode);
        }
    }

    public void deleteContact(String phoneNumber) {
        for (int i = 0; i < contactCount; i++) {
            if (contacts[i].getPhoneNumber().equals(phoneNumber)) {
                contacts[i] = contacts[contactCount - 1]; // Replace with the last contact
                contacts[contactCount - 1] = null;
                contactCount--;
                break;
            }
        }
    }

    
    public void addContactToGroup(String phoneNumber, Group group) throws DuplicateContactInGroup, ContactLimitExceededException,DuplicateContactInGroup{
        Contact contact = getContact(phoneNumber);
        
        if (contact != null) {
        	
        if (contactCount >= contacts.length) {
        	
        	throw new ContactLimitExceededException("No more contacts can be added to this group.");    // Throw an exception if the contact list is full
          
        }
    
      
        
        group.addContact(contact);
        contact.addGroup(group);
   
      }
  } 
    public void removeContactFromGroup(String phoneNumber, Group group)throws ContactNotFound {
		Contact contact = getContact(phoneNumber);
		if (contact != null) {
			group.removeContact(contact);
			contact.removeGroup(group);
		}
		
	}
    
    public Contact[] getAllContacts() {
        return contacts;
    }
 
    public Contact[] getAllContactSorted() {
    	Contact[] sortedContacts = new Contact[contactCount];
        // Copying
        for (int i = 0; i < contactCount; i++) {
            sortedContacts[i] = contacts[i];
        }

        // Bubble sort the copied array
        boolean swapped;
        for (int i = 0; i < contactCount - 1; i++) {
            swapped = false;
            for (int j = 0; j < contactCount - i - 1; j++) {
                if (sortedContacts[j].compareTo(sortedContacts[j + 1]) > 0) {
                    // Swap sortedContacts[j] and sortedContacts[j + 1]
                    Contact temp = sortedContacts[j];
                    sortedContacts[j] = sortedContacts[j + 1];
                    sortedContacts[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // No swapping means the array is already sorted
        }
        return sortedContacts;
        
    }
//    public Contact[] getAllContactSortedByName() {
//    	Contact[] sortedContacts = new Contact[contactCount];
//        // Copying
//        for (int i = 0; i < contactCount; i++) {
//            sortedContacts[i] = contacts[i];
//        }
//
//        // Bubble sort the copied array
//        boolean swapped;
//        for (int i = 0; i < contactCount - 1; i++) {
//            swapped = false;
//            for (int j = 0; j < contactCount - i - 1; j++) {
//                if (sortedContacts[j].compareTo(sortedContacts[j + 1]) > 0) {
//                    // Swap sortedContacts[j] and sortedContacts[j + 1]
//                    Contact temp = sortedContacts[j];
//                    sortedContacts[j] = sortedContacts[j + 1];
//                    sortedContacts[j + 1] = temp;
//                    swapped = true;
//                }
//            }
//            if (!swapped) break; // No swapping means the array is already sorted
//        }
//        return sortedContacts;
//        
//    }

	
    
	
}