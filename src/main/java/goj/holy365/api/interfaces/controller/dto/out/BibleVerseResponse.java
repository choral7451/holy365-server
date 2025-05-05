package goj.holy365.api.interfaces.controller.dto.out;

import goj.holy365.api.application.facade.dto.out.BibleVerseInfo;
import io.swagger.v3.oas.annotations.media.Schema;

public record BibleVerseResponse(
	@Schema(description = "성경 장", example = "1")
	Integer chapter,

	@Schema(description = "성경 절", example = "1")
	Integer verse,

	@Schema(description = "절 내용", example = "태초에 하나님이 천지를 창조하시니라")
	String content
) {
	public static BibleVerseResponse fromInfo(BibleVerseInfo info) {
		return new BibleVerseResponse(
			info.chapter(),
			info.verse(),
			info.content()
		);
	}
}
