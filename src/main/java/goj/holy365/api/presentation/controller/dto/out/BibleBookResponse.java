package goj.holy365.api.presentation.controller.dto.out;

import goj.holy365.api.application.facade.dto.out.BibleBookInfo;
import io.swagger.v3.oas.annotations.media.Schema;

public record BibleBookResponse(
	@Schema(description = "신구약 분류", example = "OLD")
	String testament,

	@Schema(description = "한국 명", example = "창세기")
	String nameKo,

	@Schema(description = "영어 명", example = "Genesis")
	String nameEn,

	@Schema(description = "정렬 순서", example = "1")
	Integer orderIndex

) {
	public static BibleBookResponse fromInfo(BibleBookInfo info) {
		return new BibleBookResponse(
			info.testament(),
			info.nameKo(),
			info.nameEn(),
			info.orderIndex()
		);
	}
}
