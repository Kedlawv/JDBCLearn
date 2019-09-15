package sda.database.dao;

import sda.database.entity.NfcChip;

import java.util.List;

public interface NfcChipDAO {

    void save(NfcChip chip);
    NfcChip findByID(int id);
    List<NfcChip> findAll();
    void update(NfcChip chip);
    void delete(int id);
}
