package ch.unisg.backend.infrastructure.repository.sdn.mapper;

import ch.unisg.backend.core.domain.entities.classes.sos.SystemClass;
import ch.unisg.backend.infrastructure.repository.sdn.node.SystemNode;

public class SystemMapper {

  public static SystemClass toSystem(SystemNode systemNode) {

    SystemClass systemClass = SystemClass.create(systemNode.getId(), systemNode.getTitle(), systemNode.getIsCyber());
    systemClass.getSystemElementList().addAll(SystemElementMapper.toSystemElementList(systemNode.systemElementNodes));
    systemClass.getIssueList().addAll(IssueMapper.toIssueList(systemNode.issueNodes));
    systemClass.getNonFunctionalRequirementList().addAll(
        NonFunctionalRequirementMapper.toNonFunctionalRequirementList(systemNode.nonFunctionalRequirementNodes));
    systemClass.getRationaleList().addAll(RationaleMapper.toRationaleList(systemNode.architectureRationaleNodes));

    return systemClass;
  }

}
