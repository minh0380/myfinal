# 아파트를 부탁해
## 1. com/kh/aboo/admin
- Admin 액터가 사용할 관리비 업로드&다운로드, 차량QR등록, 투표생성, 일정생성, 세대 권한 관리 기능이 있는 패키지로 car, index, mgmtfee, schedule, vote 패키지가 존재
> ### vote
> - Admin 액터가 투표를 관리할 때 사용하는 기능을 구현한 패키지
> - AdminVoteController의 Method : 투표 생성, 투표 수정, 투표 삭제, 투표 종료
## 2. com/kh/aboo/bdmin
- Bdmin 액터가 사용할 아파트 관리, Admin 계정 관리 기능이 있는 패키지로 management, notice 패키지가 존재
> ### notice
> - Bdmin 액터가 Admin 액터에게 보여줄 공지사항을 관리할 때 사용하는 기능을 구현한 패키지
> - NoticeController의 Method : 공지사항 목록 출력, 공지사항 상세화면 출력, 공지사항 작성, 공지사항 수정, 공지사항 삭제
## 3. com/kh/aboo/board
- 정보&질문 게시판, 인테리어 게시판, 중고거래 게시판 CRUD 패키지로 info, interior, used 패키지가 존재
> ### interior
> - Generation 액터가 인테리어 게시판의 글 및 댓글을 CRUD할 기능을 구현한 패키지
> - Admin 액터가 인테리어 게시판 글 및 댓글을 관리할 수 있는 기능을 구현한 패키지
> - InteriorController의 Method : 인테리어 게시글 목록 출력, 인테리어 게시글 상세화면 출력, 인테리어 게시글 작성, 인테리어 게시글 수정, 인테리어 게시글 삭제, 인테리어 댓글 작성, 인테리어 댓글 수정, 인테리어 댓글 삭제, 인테리어 게시글 비공개 처리(Admin 권한), 인테리어 댓글 비공개 처리(Admin 권한), 인테리어 게시글 제목으로 검색
## 4. com/kh/aboo/myapt
- 내 아파트 일정, 주변 공공기관, 주차현황 및 차량 등록 신청, 투표하기 기능이 있는 패키지로 aptSchedule, institutions, parking, vote 패키지가 존재
> ### institutions
> - Generation 액터가 본인 아파트 주변의 공공기관 위치 정보를 얻을 때 사용하는 기능을 구현한 패키지
> - InstitutionsController의 Method : view에서 아파트 주변 공공기관의 위치를 출력하기 위해 아파트의 위치 정보를 view로 보내는 메서드가 존재
> ### vote
> - Generation 액터가 생성된 투표를 확인할 수 있는 기능을 구현한 패키지
> - GenerationWon 액터가 생성된 투표에 참여할 수 있는 기능을 구현한 패키지
> - VoteController의 Method : 투표 목록 출력, 투표 상세화면 출력, 투표 참여 여부 확인, 전화번호 문자 인증, 세대원 인증, 표 행사, 투표 제목으로 검색
## 5. com/kh/aboo/mypage
- 내 알람, 내 차량, 내 관리비 확인 및 결제, 내가 작성한 글 확인 기능이 있는 패키지로 myalarm, mycar, mymgmtfee, writelist 패키지가 존재
> ### writelist
> - Generation 액터가 본인이 정보&질문 게시판, 인테리어 게시판, 중고거래 게시판에 작성한 글을 확인할 수 있는 기능을 구현한 패키지
> - WriteListController의 Method : 내가 작성한 정보&질문 게시글 목록 출력, 내가 작성한 인테리어 게시글 목록 출력, 내가 작성한 중고거래 게시글 목록 출력
