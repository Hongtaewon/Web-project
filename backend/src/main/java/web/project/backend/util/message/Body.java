package web.project.backend.util.message;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Body<T>
{
	private T any;

	protected Body()
	{
	}

	@JsonGetter("Any")
	public T getAny()
	{
		return this.any;
	}

	@JsonSetter("Any")
	public void setAny(T any)
	{
		this.any = any;
	}
	
	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
