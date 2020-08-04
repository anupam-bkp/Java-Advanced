package com.example.models;

public class MyCommandBean {

	private String command;
	
	private int id;

	public MyCommandBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyCommandBean(String command, int id) {
		super();
		this.command = command;
		this.id = id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyCommandBean other = (MyCommandBean) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyCommandBean [command=" + command + ", id=" + id + "]";
	}
	
}
