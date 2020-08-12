package web.project.backend.util.message;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Return
{
	private String result = StringUtils.EMPTY;
	private String reason = StringUtils.EMPTY;

	protected Return()
	{
	}

	@JsonGetter("result")
	public String getResult()
	{
		return this.result;
	}

	@JsonSetter("result")
	public void setResult(String result)
	{
		this.result = result;
	}

	@JsonGetter("reason")
	public String getReason()
	{
		return this.reason;
	}

	@JsonSetter("reason")
	public void setReason(String reason)
	{
		this.reason = reason;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
