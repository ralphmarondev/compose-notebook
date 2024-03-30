# About
> In this module, we implemented onboarding screen with shared preferences

# What we did
> We also call the [GuessingGameActivity] in our [MainActivity] from app module

# How we did
> In order to call this activity in the main-activity, we undergo some steps:
1. we add this module in the gradle.file of MainActivity
   - implementation(project(":guessing_game"))
2. we call this with some code in MainActivity 
   - Declare this on top of onCreate:
     - private val startNewActivity =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()){}
   - Call this inside setContent {...}
     - startNewActivity.launch(Intent(this, GuessingGameActivity::class.java))
