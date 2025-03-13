package com.domain.project.common.basestructure.dto;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

import java.time.ZonedDateTime;

public class BaseResponseDto {
    @JsonSerialize(
            using = ZonedDateTimeSerializer.class
    )
    @JsonDeserialize(
            using = ZonedDateTimeDeserializer.class
    )
    private ZonedDateTime createdAt;
    @JsonSerialize(
            using = ZonedDateTimeSerializer.class
    )
    @JsonDeserialize(
            using = ZonedDateTimeDeserializer.class
    )
    private ZonedDateTime updatedAt;

    protected BaseResponseDto(BaseResponseDtoBuilder<?, ?> b) {
        this.createdAt = b.createdAt;
        this.updatedAt = b.updatedAt;
    }

    public static BaseResponseDtoBuilder<?, ?> builder() {
        return new BaseResponseDtoBuilderImpl();
    }

    public ZonedDateTime getCreatedAt() {
        return this.createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    @JsonDeserialize(
            using = ZonedDateTimeDeserializer.class
    )
    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @JsonDeserialize(
            using = ZonedDateTimeDeserializer.class
    )
    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BaseResponseDto() {
    }

    public BaseResponseDto(ZonedDateTime createdAt, ZonedDateTime updatedAt, String updatedBy) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public abstract static class BaseResponseDtoBuilder<C extends BaseResponseDto, B extends BaseResponseDtoBuilder<C, B>> {
        private ZonedDateTime createdAt;
        private ZonedDateTime updatedAt;
        private String updatedBy;

        public BaseResponseDtoBuilder() {
        }

        @JsonDeserialize(
                using = ZonedDateTimeDeserializer.class
        )
        public B createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return (B)this.self();
        }

        @JsonDeserialize(
                using = ZonedDateTimeDeserializer.class
        )
        public B updatedAt(ZonedDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return (B)this.self();
        }

        public B updatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
            return (B)this.self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            String var10000 = String.valueOf(this.createdAt);
            return "BaseResponseDto.BaseResponseDtoBuilder(createdAt=" + var10000 + ", updatedAt=" + String.valueOf(this.updatedAt) + ", updatedBy=" + this.updatedBy + ")";
        }
    }

    private static final class BaseResponseDtoBuilderImpl extends BaseResponseDtoBuilder<BaseResponseDto, BaseResponseDtoBuilderImpl> {
        private BaseResponseDtoBuilderImpl() {
        }

        protected BaseResponseDtoBuilderImpl self() {
            return this;
        }

        public BaseResponseDto build() {
            return new BaseResponseDto(this);
        }
    }
}
