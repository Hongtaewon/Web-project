package web.project.backend.util.message;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Body<T>
{
	private T any;
	private List<T> anyList;

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

	@JsonGetter("AnyList")
	public List<T> getAnyList()
	{
		return this.anyList;
	}
	@JsonSetter("AnyList")
	public void setAnyList(List<T> anyList)
	{
		this.anyList = anyList;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
