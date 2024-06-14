package com.example.modules.dept.Rep;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * @author honor
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeptRep implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

}
