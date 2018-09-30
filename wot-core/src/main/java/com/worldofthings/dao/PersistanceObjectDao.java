package com.worldofthings.dao;



import java.util.Optional;

import com.worldofthings.vo.VirtualObjectVO;

public interface PersistanceObjectDao {
	
	/*Persistance Repository (CassandaraRepository or HibernateRepository operations abstraction
	 Object Curd Operation will  work with Virual Objects to hide the persistance abstraction
	 * */

    VirtualObjectVO getByName(String name);

    int delete(String name);

    void persist(VirtualObjectVO configuration);

    VirtualObjectVO merge(VirtualObjectVO existing);
}
