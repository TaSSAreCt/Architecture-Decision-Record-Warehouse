import {System} from "$lib/domain/entity/sos/System.svelte";

export function getSystemOfSystems(systemsOfSystems: System[], id: string) : System | undefined {

    for (const systemOfSystems of systemsOfSystems) {
        if (systemOfSystems.id === id) {
            return systemOfSystems;
        }

        const found = traverse(systemOfSystems, id);
        if (found) return found;
    }

    return undefined; // fallback if nothing found
};

function traverse(systemOfSystems: System, id: string): System | undefined {
    for (const child of systemOfSystems.systemList) {
        if (child.id === id) {
            return child;
        }

        const found = traverse(child, id);
        if (found) return found;
    }

    return undefined;
}


export function getSystems(cpsos: System[]) : System[] {

    function traverse(sos : System[], child : System) {
        sos.push(child);

        child.systemList.forEach((system) => {
            traverse(sos, system);
        })
    }

    const sos : System[] = [];

    cpsos.forEach(system => {
        sos.push(system);

        system.systemList.forEach(child => {
            traverse(sos, child);
        })
    })

    return sos;
}