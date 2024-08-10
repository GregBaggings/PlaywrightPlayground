package dto;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDto {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<StarWarsCharacter> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<StarWarsCharacter> getResults() {
        return results;
    }

    public void setResults(List<StarWarsCharacter> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResponseDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("count");
        sb.append('=');
        sb.append(((this.count == null) ? "<null>" : this.count));
        sb.append(',');
        sb.append("next");
        sb.append('=');
        sb.append(((this.next == null) ? "<null>" : this.next));
        sb.append(',');
        sb.append("previous");
        sb.append('=');
        sb.append(((this.previous == null) ? "<null>" : this.previous));
        sb.append(',');
        sb.append("results");
        sb.append('=');
        sb.append(((this.results == null) ? "<null>" : this.results));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
