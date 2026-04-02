package com.pabitra.ams.config.attendance;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.asm.MemberSubstitution;

@Data
@NoArgsConstructor
public class SubjectRecordKey {

    private String batch;
    private String subCode;
    private String section;
}
