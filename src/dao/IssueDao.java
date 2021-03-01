package dao;

import java.util.List;

import models.Issue;

public interface IssueDao {
	public Integer addIssue(Issue issue);
	public Integer updateIssue(Issue issue);
	public Integer deleteIssue(Integer id);
	public Integer getIdByName(Integer id);
	public Issue getIssueById(Integer id);
	public List<Issue> getAllIssue();

}
