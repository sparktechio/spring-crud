package com.sparktechcode.springcrud.payloads;

import java.util.List;

public record PageData<D>(List<D> items, long total) {
}
