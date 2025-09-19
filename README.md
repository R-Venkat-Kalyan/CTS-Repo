# Useful-Links-Notes

https://dev.to/javafullstackdev/master-whatsapp-api-integration-in-your-spring-boot-application-4o7j

https://www.baeldung.com/spring-boot-react-crud

N8N: https://www.youtube.com/watch?v=2GZ2SNXWK-c

Survey: https://www.youtube.com/watch?v=ClU-cJVqRLQ

Pega Topics: https://www.softlogicsys.in/pega-course-syllabus/

Pegs Projects: https://3cross3tech.ongraphy.com/courses/Pega-Projects-62bc50ee0cf2f9e2a999a0a0

Pega Projrects1: https://pega.devpost.com/project-gallery?page=2

Env: https://forms.cloud.microsoft/pages/responsepage.aspx?id=B8QI3rkZfUKf6O3yVDAMpzfievctKntFjC7V5S8ws7lUQjhTRkQ4OTBORVJBME5SV0hTMUhOV1ZFRS4u&origin=QRCode&route=shorturl


Fetched all branches using Obj-Browse into a list page.

Looped through each branch in that list.

Checked if the branch had any rules using the OOTB data page D_pzBranchContent.

If empty → deleted the branch by calling the OOTB activity pxDeleteBranch.

If not empty → skipped deletion and moved to the next branch.
