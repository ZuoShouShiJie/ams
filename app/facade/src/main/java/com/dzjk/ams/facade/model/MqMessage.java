package com.dzjk.ams.facade.model;

public class MqMessage {
	
	   private String topic;

	    private String eventcode;

	    private Object payload;

	    public MqMessage() {
	    }

	    public MqMessage(String topic, String eventcode, Object payload) {
	        this.topic = topic;
	        this.eventcode = eventcode;
	        this.payload = payload;
	    }

	    /**
	     * Getter method for property <tt>topic</tt>.
	     *
	     * @return property value of topic
	     */
	    public String getTopic() {
	        return topic;
	    }

	    /**
	     * Setter method for property <tt>topic</tt>.
	     *
	     * @param topic value to be assigned to property topic
	     */
	    public void setTopic(String topic) {
	        this.topic = topic;
	    }

	    /**
	     * Getter method for property <tt>eventcode</tt>.
	     *
	     * @return property value of eventcode
	     */
	    public String getEventcode() {
	        return eventcode;
	    }

	    /**
	     * Setter method for property <tt>eventcode</tt>.
	     *
	     * @param eventcode value to be assigned to property eventcode
	     */
	    public void setEventcode(String eventcode) {
	        this.eventcode = eventcode;
	    }

	    /**
	     * Getter method for property <tt>payload</tt>.
	     *
	     * @return property value of payload
	     */
	    public Object getPayload() {
	        return payload;
	    }

	    /**
	     * Setter method for property <tt>payload</tt>.
	     *
	     * @param payload value to be assigned to property payload
	     */
	    public void setPayload(Object payload) {
	        this.payload = payload;
	    }

}
