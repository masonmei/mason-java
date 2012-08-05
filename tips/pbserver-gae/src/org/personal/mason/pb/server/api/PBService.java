package org.personal.mason.pb.server.api;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.personal.mason.pb.server.api.model.PBAccount;
import org.personal.mason.pb.server.api.model.PBRelation;

public interface PBService {

public PBAccount createAccount(PBAccount account, HttpServletResponse response);


public PBAccount validateAccount(PBAccount account,  HttpServletResponse response);


public PBAccount modifyAccount(PBAccount account, HttpServletResponse response);


public Set<PBRelation> listRelations(String token);


public PBRelation addRelation(PBRelation relation, String token);


public PBRelation modifyRelation(PBRelation relation, String token);

public boolean deleteRelation(Long id, String token);


public boolean deleteRecord(Long id, String token);


public boolean deleteResource(Long id, String token);


public Set<PBRelation> getRelations(String type,
        String value,
        String token);


public Set<PBRelation> getRelations(String type,
        String title,
        String value,
        String token);

}
