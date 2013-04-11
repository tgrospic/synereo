import com.ati.iaservices.recipes.LauncherPluginSession._
import com.ati.iaservices.recipes._
import com.protegra_ati.agentservices.core.schema.Profile
import java.util.UUID

// START STORE and UI PlatformAgents
new CreateStorePlugin().run()
new CreateUIPlugin().run()

// CREATE PROFILE FOR ALREADY EXISTING AGENT
session.agentSessionId = UUID.randomUUID
session.userAgentId = UUID.fromString("5a0660bf-eab6-4c40-9c9f-62e0c6365103")

val profile = new Profile()
profile.setFirstName("Jone")
profile.setLastName("Smith")
profile.setCity("Winnipeg")
profile.setCountry("Canada")

val setContentPlugin = new SetContentPlugin[Profile]
setContentPlugin.data = profile
setContentPlugin.oldData = null
setContentPlugin.run()

val getContentPlugin = new GetContentPlugin[Profile]()
getContentPlugin.queryObject = Profile.SEARCH_ALL
getContentPlugin.run()

