package Models;

import java.sql.Date;
import java.sql.Timestamp;

public class UserModel {
	private long id;
	private String username;
    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	private String fullname;
    private String phoneNumber;
    private String address;
    private String email;
    public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	private String password;
    public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

	private Boolean isActive;
    private Date dateOfBirth;
    private String image;
    private int roleId;
    private Timestamp createdAt;
    private Timestamp updatedAt;


	public UserModel(long id, String username, String fullname, String phoneNumber, String address,String email, String password,
			Boolean isActive, Date dateOfBirth,String image , int roleId,
			Timestamp timestamp, Timestamp timestamp2) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.password = password;
		this.isActive = isActive;
		this.dateOfBirth = dateOfBirth;
		this.roleId = roleId;
		this.createdAt = timestamp;
		this.updatedAt = timestamp2;
		this.email=email;
		this.image=image;
	}

	public UserModel(String username, String fullname, String phoneNumber, String address, String email,
			String password, Boolean isActive, Date dateOfBirth, int roleId, Timestamp createdAt) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.dateOfBirth = dateOfBirth;
		this.roleId = roleId;
		this.createdAt = createdAt;
	}
	
	//fb
	


	// Default constructor
    public UserModel() {
    }



	public UserModel(String username, String fullname, String phoneNumber, String address, String email,
			String password, Boolean isActive, Date dateOfBirth, String image, int roleId, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.dateOfBirth = dateOfBirth;
		this.image = image;
		this.roleId = roleId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	public UserModel(String fullname, Boolean isActive, int roleId, Timestamp createdAt) {
		super();
		this.fullname = fullname;
		this.isActive = isActive;
		this.roleId = roleId;
		this.createdAt = createdAt;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}


	// Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
