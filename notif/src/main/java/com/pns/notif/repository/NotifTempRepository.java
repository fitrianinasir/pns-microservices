package com.pns.notif.repository;

import com.pns.notif.dto.INotifData;
import com.pns.notif.dto.ITemplateBody;
import com.pns.notif.model.NotifTmpModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotifTempRepository extends JpaRepository<NotifTmpModel, Integer> {
    @Transactional
    @Modifying
    @Query(value = "SELECT p.txn_reffno, p.recipient, p.template_id, p.template_params, p.flag " +
            "FROM TBL_NOTIF_TMP p WHERE p.FLAG = 'N' FETCH FIRST 3 ROWS ONLY", nativeQuery = true)
    List<INotifData> selectToUpdate();

    @Transactional
    @Query(value = "SELECT p.template_body from TBL_TEMPLATE p WHERE p.template_id = :templateId", nativeQuery = true)
    ITemplateBody getTemplateBody(@Param("templateId") String templateId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE TBL_NOTIF_TMP SET FLAG = 'Y' WHERE TXN_REFFNO = :reffno", nativeQuery = true)
    void updateFlagData(@Param("reffno") String reffno);
}
