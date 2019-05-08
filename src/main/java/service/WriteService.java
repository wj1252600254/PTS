package service;

public interface WriteService {
    public int deleteObject(String sql, Object... name);

    public int updateObject(String sql, Object... name);

    public int insertObject(String sql, Object... name);
}
