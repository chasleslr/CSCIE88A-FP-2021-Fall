package cscie88a.week4;

import com.google.common.base.Objects;

public class Cat {

	protected String name;
	protected String eyeColor;
	protected String bodyColor;
	protected Integer age;
	protected Boolean healthCheckDone;

	public Cat() {
		super();
	}

	public Cat(String name, String eyeColor, String bodyColor, Integer age, Boolean healthCheckDone) {
		super();
		this.name = name;
		this.eyeColor = eyeColor;
		this.bodyColor = bodyColor;
		this.age = age;
		this.healthCheckDone = healthCheckDone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getBodyColor() {
		return bodyColor;
	}

	public void setBodyColor(String bodyColor) {
		this.bodyColor = bodyColor;
	}

	public Boolean getHealthCheckDone() {
		return healthCheckDone;
	}

	public void setHealthCheckDone(Boolean healthCheckDone) {
		this.healthCheckDone = healthCheckDone;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cat cat = (Cat) o;
		return Objects.equal(name, cat.name) && Objects.equal(eyeColor, cat.eyeColor) && Objects.equal(bodyColor, cat.bodyColor);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name, eyeColor, bodyColor);
	}

	@Override
	public String toString() {
		return "Cat{" +
				"name='" + name + '\'' +
				", eyeColor='" + eyeColor + '\'' +
				", bodyColor='" + bodyColor + '\'' +
				'}';
	}
}