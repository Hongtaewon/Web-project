package web.project.backend.util.message;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Header
{
	private String event_id = "";
	private String request_id = "";
	private String eventTime = "";
	
	public Header() {
		
	}
	
	public Header(String tableName) {
		this.event_id = "blog-"+tableName;
		this.eventTime = LocalDateTime.now().toString();
	}
	
	@JsonGetter("event_id")
	public String getEventId()
	{
		return this.event_id;
	}

	@JsonSetter("event_id")
	public void setEventId(String event_id)
	{
		this.event_id = event_id;
	}
	
	@JsonGetter("eventTime")
	public String getEventTime()
	{
		return this.eventTime;
	}

	@JsonSetter("eventTime")
	public void setEventTime()
	{
		this.eventTime = LocalDateTime.now().toString();
	}
	
	@JsonGetter("request_id")
	public String getRequestId()
	{
		return this.request_id;
	}

	@JsonSetter("request_id")
	public void setRequestId(String request_id)
	{
		this.request_id = request_id;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
