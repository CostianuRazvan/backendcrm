package net.reply.backendcrm.dao;

import java.util.List;

import net.reply.backendcrm.dto.Templates;

public interface TemplatesDAO {
	boolean add(Templates templates);
	List<Templates> list();
	boolean update(Templates templates);
	List<Templates> get(String name);
	boolean deleteTemplate(int id);
}
