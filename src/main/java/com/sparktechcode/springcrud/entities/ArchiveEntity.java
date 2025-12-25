package com.sparktechcode.springcrud.entities;

import java.time.Instant;

public interface ArchiveEntity {
    Instant getArchived();
    void setArchived(Instant archived);
}
