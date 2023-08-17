package com.kafka.consumer.pojo;

public class Message {
private String key;
private String Value;
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public String getValue() {
	return Value;
}
public void setValue(String value) {
	Value = value;
}
@Override
public String toString() {
	return "Message [key=" + key + ", Value=" + Value + "]";
}

}
