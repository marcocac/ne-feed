package model;

public class ConditionBase {

	private String conditionType;
	private String conditionVar;
	private Object value;

	public String getConditionType() {
		return conditionType;
	}

	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object value) {
			this.value = value;
	}

	public String getConditionVar() {
		return conditionVar;
	}

	public void setConditionVar(String conditionVar) {
		this.conditionVar = conditionVar;
	}

	@Override
	public String toString() {
		return "ConditionBase [conditionType=" + conditionType
				+ ", conditionVar=" + conditionVar + ", value=" + value + "]";
	}

}
