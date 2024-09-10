package miniProject2;
import java.util.Scanner;

import miniProject.ContactLimitExceededException;
import miniProject.DuplicateContactException;
import miniProject.DuplicateContactInGroup;
import miniProject.DuplicateGroupNameException;
import miniProject.DuplicateNameException;
import miniProject.PhoneNumberLimitException;
import miniProject.StringLimitException;

public class MainClass {

	public static void main(String[] args) throws DuplicateContactException {
		ContactServices contactService = new ContactServices(2); // Initial size of 10 contacts
        GroupServices groupService = new GroupServices(5); // Initial size of 5 groups

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean flag=true;
        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Create a contact");
            System.out.println("2. Create a group");
            System.out.println("3. Add a contact to a group");
            System.out.println("4. Remove a contact from a group");
            System.out.println("5. Update a contact");
            System.out.println("6. Delete a contact");
            System.out.println("7. Delete a group");
            System.out.println("8. View contacts in a group");
            System.out.println("9. View all contacts");
            System.out.println("10. View all groups");
            System.out.println("11. View all the contacts sorted by phone number");
            System.out.println("12. View all the groups sorted by Name");
            System.out.println("13.Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter country code: ");
                    String countryCode = scanner.nextLine();
                  
				try {
					contactService.createContact(name, phoneNumber, countryCode);
					System.out.println("contact created successfully");
					
				   }
				catch (ContactLimitExceededException e) {
					flag=false;
					System.out.println("Failed to create contact");
					e.printStackTrace();
					System.out.println(e.getMessage());
					
				}catch(PhoneNumberLimitException pe) {
					flag=false;
					pe.printStackTrace();
					System.out.println(pe.getMessage());
				}
				catch(DuplicateContactException de) {
					System.out.println(de.getMessage());
			
					de.printStackTrace();
				}catch(DuplicateNameException dname) {
					dname.printStackTrace();
					System.out.println(dname.getMessage());
				}

			               
                    break;

                case 2:
                    System.out.print("Enter group name: ");
                    String groupName = scanner.nextLine();
                    System.out.print("Enter group description: ");
                    String groupDescription = scanner.nextLine();
                    
				
					try {
                    groupService.createGroup(groupName, groupDescription);
                    System.out.println("Group created successfully.");
                    
                    }catch(DuplicateGroupNameException dge) {
                    	dge.printStackTrace();
                    	System.out.println(dge.getMessage());
                    	
                    }
				 
                    
                    break;

                case 3:
                    System.out.print("Enter the contact's phone number: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter the group name to add the contact to: ");
                    groupName = scanner.nextLine();
                    
                    Group groupToAdd = groupService.getGroup(groupName);
                    
                    if (groupToAdd != null) {
                        try {
							contactService.addContactToGroup(phoneNumber, groupToAdd);
							System.out.println("Contact added to group successfully.");
						}  catch (DuplicateContactInGroup dgce) {
							
							dgce.printStackTrace();
						
							System.out.println(	dgce.getMessage());
							
						} catch (ContactLimitExceededException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println(e.getMessage());
						}
                      
                    } else {
                        System.out.println("Group not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the contact's phone number: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter the group name to remove the contact from: ");
                    groupName = scanner.nextLine();
                    Group groupToRemove = groupService.getGroup(groupName);
                    if (groupToRemove != null) {
                    	
                    	
                    	try {
                    		contactService.removeContactFromGroup(phoneNumber, groupToRemove);
                    	}
                        
                        catch(ContactNotFound c) {
                        	
                        	System.out.println(c.getMessage());
                        }
                        
                        
                        System.out.println("Contact removed from group successfully.");
                    } else {
                        System.out.println("Group not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter the phone number of the contact to update: ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new country code: ");
                    String newCountryCode = scanner.nextLine();
                    contactService.updateContact(phoneNumber, newName, newCountryCode);
                    System.out.println("Contact updated successfully.");
                    break;

                case 6:
                    System.out.print("Enter the phone number of the contact to delete: ");
                    phoneNumber = scanner.nextLine();
                    contactService.deleteContact(phoneNumber);
                    System.out.println("Contact deleted successfully.");
                    break;

                case 7:
                    System.out.print("Enter the name of the group to delete: ");
                    groupName = scanner.nextLine();
                    groupService.deleteGroup(groupName);
                    System.out.println("Group deleted successfully.");
                    break;

                case 8:
                    System.out.print("Enter the group name to view contacts: ");
                    groupName = scanner.nextLine();
                    Group groupToView = groupService.getGroup(groupName);
                    if (groupToView != null) {
                        System.out.println("Contacts in group " + groupName + ":");
                        for (Contact contact : groupToView.getContacts()) {
                            if (contact != null) {
                                System.out.println(contact.getName() + " (" + contact.getPhoneNumber() + ")");
                            }
                        }
                    } else {
                        System.out.println("Group not found.");
                    }
                    break;

                case 9:
                    System.out.println("All contacts:");
                    for (Contact contact : contactService.getAllContacts()) {
                        if (contact != null) {
                            System.out.println(contact.getName() + " (" + contact.getPhoneNumber() + ")");
                        }
                    }
                    break;

                case 10:
                    System.out.println("All groups:");
                    for (Group group : groupService.getAllGroups()) {
                        if (group != null) {
                            System.out.println(group.getGroupName() + " (" + group.getGroupDescription() + ")");
                        }
                    }
                    break;
                    
                case 11:
                    System.out.println("All contacts sorted by phone number:");
                    Contact[] sortedContacts = contactService.getAllContactSorted();
                    for (Contact contact : sortedContacts) {
                        if (contact != null) {
                            System.out.println(contact.getName() + " ||" + contact.getPhoneNumber() );
                        }
                    }
                    break;    
                case 12:
                    System.out.println("All contacts sorted by Group Name:");
                    Group[] sortedGroup = groupService.getAllGroupSorted();
                    for (Group group : sortedGroup) {
                        if (group != null) {
                            System.out.println(group.getGroupName() + " ||" + group.getGroupDescription() );
                        }
                    }
                    break;      
                case 13:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
          scanner.close();
        System.out.println("Exiting...");	
	}	
}
