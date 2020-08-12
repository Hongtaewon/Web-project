package web.project.backend.util.message;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

public class APIMessage<T>
{
	private Header header;
	private Body<T> body;
	private Return _return;

	protected APIMessage()
	{
		this("");
	}

	public APIMessage(String tableName)
	{
		this.header = new Header(tableName);
		this.body = new Body<T>();
		this._return = new Return();
	}

	@JsonGetter("Header")
	public Header getHeader()
	{
		return this.header;
	}

	@JsonSetter("Header")
	public void setHeader(Header header)
	{
		this.header = header;
	}

	@JsonGetter("Body")
	public Body<T> getBody()
	{
		return this.body;
	}

	@JsonSetter("Body")
	public void setBody(Body<T> body)
	{
		this.body = body;
	}

	@JsonGetter("Return")
	public Return getReturn()
	{
		return this._return;
	}

	@JsonSetter("Return")
	public void setReturn(Return _return)
	{
		this._return = _return;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
