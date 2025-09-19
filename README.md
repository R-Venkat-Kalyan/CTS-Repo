# Useful-Links-Notes

https://dev.to/javafullstackdev/master-whatsapp-api-integration-in-your-spring-boot-application-4o7j

https://www.baeldung.com/spring-boot-react-crud

N8N: https://www.youtube.com/watch?v=2GZ2SNXWK-c

Survey: https://www.youtube.com/watch?v=ClU-cJVqRLQ

Pega Topics: https://www.softlogicsys.in/pega-course-syllabus/

Pegs Projects: https://3cross3tech.ongraphy.com/courses/Pega-Projects-62bc50ee0cf2f9e2a999a0a0

Pega Projrects1: https://pega.devpost.com/project-gallery?page=2

Env: https://forms.cloud.microsoft/pages/responsepage.aspx?id=B8QI3rkZfUKf6O3yVDAMpzfievctKntFjC7V5S8ws7lUQjhTRkQ4OTBORVJBME5SV0hTMUhOV1ZFRS4u&origin=QRCode&route=shorturl


🔹 Pages & Classes

TempPage – Code-Pega-List

What: A page of type Code-Pega-List, the generic list structure in Pega that holds multiple results from an Obj-Browse.

Why: Obj-Browse always returns results in a list format (pxResults). This lets you loop through those results.

How: You defined TempPage in Pages & Classes to be Code-Pega-List so it can legally hold query results.

TempPage.pxResults – Rule-RuleSet-Branch

What: Each row (pxResults(n)) will be of class Rule-RuleSet-Branch.

Why: Because you are browsing the Rule-RuleSet-Branch class (branches). Each branch is represented as a row.

How: By mapping pxResults to this class, Pega lets you access branch-specific properties like .pyBranchID and .pzInsKey.

🔹 Step 1 — Obj-Browse (TempPage)

What: Queries the database table for all instances of Rule-RuleSet-Branch (branches).

Why: You need a list of all branches to evaluate which ones are empty.

How:

PageName: TempPage → results go into TempPage.

ObjClass: Rule-RuleSet-Branch → you are querying branch instances.

MaxRecords: 100 → limits results for safety (avoid huge fetch).

GetRowKey: pzInsKey → fetches each branch’s unique key.

Properties selected (pzInsKey, pyBranchID) → only retrieves what you need instead of full rows, for performance.

👉 End result: TempPage.pxResults() contains all the branches.

🔹 Step 2 — Loop over TempPage.pxResults

What: Iterates through each branch row.

Why: You need to check each branch individually.

How: Loop type = For each embedded page on TempPage.pxResults. That means .pyBranchID or .pzInsKey are accessible for the current branch.

🔹 Step 2.1 — Property-Set

What: Copies .pyBranchID into a parameter.

Why: The data page D_pzBranchContent needs branchID as input to check if rules exist. By setting Param.BranchID = .pyBranchID, you prepare that input.

How:

Param.BranchID → temporary parameter variable in the activity.

.pyBranchID → property in current loop branch record.

🔹 Step 2.2 — Call pxDeleteBranch (conditional)

What: Calls the OOTB activity pxDeleteBranch to delete the branch.

Why: This is the official safe way to delete a branch in Pega.

How:

When condition → @LengthOfPageList(D_pzBranchContent[branchID:Param.BranchID].pxResults) = 0

This loads the OOTB data page D_pzBranchContent for the current branch.

.pxResults is the list of rules inside that branch.

If the count is 0, the branch is empty.

If true → continue → executes delete.

If false → skip step → branch is not deleted.

✅ Why this works better than the long approach

You avoided juggling multiple nested loops, custom counters, and handling RSVs.

You directly leveraged D_pzBranchContent (OOTB data page) to check content, instead of manually browsing RSVs and rules.

You used pxDeleteBranch (OOTB safe delete method), so you don’t need to mess with Obj-Delete/Obj-Save on Application records.

🔎 In simple words:

Step 1: Get all branches.

Step 2: Loop through each branch.

Step 2.1: Save the branch ID into a param.

Step 2.2: If no rules exist in that branch (D_pzBranchContent empty), delete the branch.
