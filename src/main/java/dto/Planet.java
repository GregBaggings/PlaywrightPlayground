package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Planet {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("rotation_period")
    @Expose
    private String rotationPeriod;
    @SerializedName("orbital_period")
    @Expose
    private String orbitalPeriod;
    @SerializedName("diameter")
    @Expose
    private String diameter;
    @SerializedName("climate")
    @Expose
    private String climate;
    @SerializedName("gravity")
    @Expose
    private String gravity;
    @SerializedName("terrain")
    @Expose
    private String terrain;
    @SerializedName("surface_water")
    @Expose
    private String surfaceWater;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("residents")
    @Expose
    private List<String> residents;
    @SerializedName("films")
    @Expose
    private List<String> films;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("edited")
    @Expose
    private String edited;
    @SerializedName("url")
    @Expose
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Planet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("rotationPeriod");
        sb.append('=');
        sb.append(((this.rotationPeriod == null) ? "<null>" : this.rotationPeriod));
        sb.append(',');
        sb.append("orbitalPeriod");
        sb.append('=');
        sb.append(((this.orbitalPeriod == null) ? "<null>" : this.orbitalPeriod));
        sb.append(',');
        sb.append("diameter");
        sb.append('=');
        sb.append(((this.diameter == null) ? "<null>" : this.diameter));
        sb.append(',');
        sb.append("climate");
        sb.append('=');
        sb.append(((this.climate == null) ? "<null>" : this.climate));
        sb.append(',');
        sb.append("gravity");
        sb.append('=');
        sb.append(((this.gravity == null) ? "<null>" : this.gravity));
        sb.append(',');
        sb.append("terrain");
        sb.append('=');
        sb.append(((this.terrain == null) ? "<null>" : this.terrain));
        sb.append(',');
        sb.append("surfaceWater");
        sb.append('=');
        sb.append(((this.surfaceWater == null) ? "<null>" : this.surfaceWater));
        sb.append(',');
        sb.append("population");
        sb.append('=');
        sb.append(((this.population == null) ? "<null>" : this.population));
        sb.append(',');
        sb.append("residents");
        sb.append('=');
        sb.append(((this.residents == null) ? "<null>" : this.residents));
        sb.append(',');
        sb.append("films");
        sb.append('=');
        sb.append(((this.films == null) ? "<null>" : this.films));
        sb.append(',');
        sb.append("created");
        sb.append('=');
        sb.append(((this.created == null) ? "<null>" : this.created));
        sb.append(',');
        sb.append("edited");
        sb.append('=');
        sb.append(((this.edited == null) ? "<null>" : this.edited));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null) ? "<null>" : this.url));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
